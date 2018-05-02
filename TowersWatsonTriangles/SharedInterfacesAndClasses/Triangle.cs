using System;
using System.Collections.Generic;

namespace SharedInterfacesAndClasses
{
    public class Triangle : ITriangle
    {
        private readonly string _productName;
        public string ProductName
        {
            get { return _productName; }
        }

        private readonly int _earlyestOriginYear;
        public int EarlyestOriginYear
        {
            get { return _earlyestOriginYear; }
        }

        private readonly int _latestOriginYear;
        public int LatestOriginYear
        {
            get { return _latestOriginYear; }
        }

        private readonly int _earlyestDevelopmentYear;
        public int EarlyestDevelopmentYear
        {
            get { return _earlyestDevelopmentYear; }
        }

        private readonly int _latestDevelopmentYear;
        public int LatestDevelopmentYear
        {
            get { return _latestDevelopmentYear; }
        }


        private readonly Dictionary<Tuple<int, int>, ITriangleDataPoint> _triangleDataDictionary = new Dictionary<Tuple<int, int>, ITriangleDataPoint>();
        private readonly int _boundaryDistance;

        public Triangle(string productName, IEnumerable<ITriangleDataPoint> dataPoints)
        {
            _productName = productName;
            _earlyestOriginYear = int.MaxValue;
            _latestOriginYear = int.MinValue;
            _earlyestDevelopmentYear = int.MaxValue;
            _latestDevelopmentYear = int.MinValue;
            _boundaryDistance = 0;

            foreach (var dataPoint in dataPoints)
            {
                if (dataPoint.OriginYear < _earlyestOriginYear)
                {
                    _earlyestOriginYear = dataPoint.OriginYear;
                }
                if (dataPoint.OriginYear > _latestOriginYear)
                {
                    _latestOriginYear = dataPoint.OriginYear;
                }
                if (dataPoint.DevelopmentYear < _earlyestDevelopmentYear)
                {
                    _earlyestDevelopmentYear = dataPoint.DevelopmentYear;
                }
                if (dataPoint.DevelopmentYear > _latestDevelopmentYear)
                {
                    _latestDevelopmentYear = dataPoint.DevelopmentYear;
                }


                var position = GetTrianglePostion(dataPoint.OriginYear, dataPoint.DevelopmentYear);

                var pointDistance = GetPointDistance(position);
                if (pointDistance > _boundaryDistance)
                {
                    _boundaryDistance = pointDistance;
                }
                
                _triangleDataDictionary.Add(position, dataPoint);
            }
        }

        public double? GetIncrementalValue(int originYear, int developmentYear)
        {
            var position = GetTrianglePostion(originYear, developmentYear);
            return GetValue(position);
        }

        public double? GetCumulativeValue(int originYear, int developmentYear)
        {
            var position = GetTrianglePostion(originYear, developmentYear);
            if (IsOutOfBounds(position))
            {
                return null;
            }

            double? result = 0;
            for (int i = 0; i <= position.Item2; i++)
            {
                result += GetValue(new Tuple<int, int>(position.Item1, i));
            }

            return result;
        }

        private Tuple<int, int> GetTrianglePostion(int originYear, int developmentYear)
        {
            return new Tuple<int, int>(originYear - EarlyestOriginYear, developmentYear - originYear);
        }

        private int GetPointDistance(Tuple<int, int> position)
        {
            return position.Item1 + position.Item2;
        }

        private bool IsOutOfBounds(Tuple<int, int> position)
        {
            return GetPointDistance(position) > _boundaryDistance;
        }

        private double? GetValue(Tuple<int, int> position)
        {
            if (IsOutOfBounds(position))
            {
                return null;
            }

            if (_triangleDataDictionary.ContainsKey(position))
            {
                return _triangleDataDictionary[position].Value;
            }

            return 0;
        }

    }
}
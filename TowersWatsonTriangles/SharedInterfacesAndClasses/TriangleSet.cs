using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SharedInterfacesAndClasses
{
    public class TriangleSet : ITriangleSet
    {
        private int _earlyestOriginYearForAllTriangles;
        public int EarlyestOriginYearForAllTriangles
        {
            get { return _earlyestOriginYearForAllTriangles; }
        }

        private int _latestOriginYearForAllTriangles;
        public int LatestOriginYearForAllTriangles
        {
            get { return _latestOriginYearForAllTriangles; }
        }

        private int _earlyestDevelopmentYearForAllTriangles;
        public int EarlyestDevelopmentYearForAllTriangles
        {
            get { return _earlyestDevelopmentYearForAllTriangles; }
        }

        private int _latestDevelopmentYearForAllTriangles;
        public int LatestDevelopmentYearForAllTriangles
        {
            get { return _latestDevelopmentYearForAllTriangles; }
        }

        private int _developmentYearRange;
        public int DevelopmentYearRange
        {
            get { return _developmentYearRange; }
        }

        private IDictionary<string, ITriangle> _triangleDictionary;
        public IDictionary<string, ITriangle> TriangleDictionary 
        { 
            get { return _triangleDictionary; }
        }

        public TriangleSet(IDictionary<string, ITriangle> triangleDictionary)
        {
            _triangleDictionary = triangleDictionary;

            var earlyestOriginYearForAllTriangles = int.MaxValue;
            var latestOriginYearForAllTriangles = int.MinValue;
            var earlyestDevelopmentYearForAllTriangles = int.MaxValue;
            var latestDevelopmentYearForAllTriangles = int.MinValue;

            foreach (var triangle in triangleDictionary.Values)
            {
                if (triangle.EarlyestOriginYear < earlyestOriginYearForAllTriangles)
                {
                    earlyestOriginYearForAllTriangles = triangle.EarlyestOriginYear;
                }
                if (triangle.LatestOriginYear > latestOriginYearForAllTriangles)
                {
                    latestOriginYearForAllTriangles = triangle.LatestOriginYear;
                }
                if (triangle.EarlyestDevelopmentYear < earlyestDevelopmentYearForAllTriangles)
                {
                    earlyestDevelopmentYearForAllTriangles = triangle.EarlyestDevelopmentYear;
                }
                if (triangle.LatestDevelopmentYear > latestDevelopmentYearForAllTriangles)
                {
                    latestDevelopmentYearForAllTriangles = triangle.LatestDevelopmentYear;
                }
            }

            _earlyestOriginYearForAllTriangles = earlyestOriginYearForAllTriangles;
            _latestOriginYearForAllTriangles = latestOriginYearForAllTriangles;
            _earlyestDevelopmentYearForAllTriangles = earlyestDevelopmentYearForAllTriangles;
            _latestDevelopmentYearForAllTriangles = latestDevelopmentYearForAllTriangles;


            _developmentYearRange = latestDevelopmentYearForAllTriangles - earlyestDevelopmentYearForAllTriangles + 1;
        }


    }
}

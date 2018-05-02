namespace SharedInterfacesAndClasses
{
    public class TriangleDataPoint : ITriangleDataPoint
    {
        private int _originYear;
        private int _developmentYear;
        private double _value;

        public TriangleDataPoint(int originYear, int developmentYear, double value)
        {
            _value = value;
            _developmentYear = developmentYear;
            _originYear = originYear;
        }

        public int OriginYear { get { return _originYear; } }
        public int DevelopmentYear { get { return _developmentYear; } }
        public double Value { get { return _value; } }
    }
}
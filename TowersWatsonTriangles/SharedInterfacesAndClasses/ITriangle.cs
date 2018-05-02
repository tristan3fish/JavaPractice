namespace SharedInterfacesAndClasses
{
    public interface ITriangle
    {
        string ProductName { get; }
        int EarlyestOriginYear { get; }
        int LatestOriginYear { get; }
        int EarlyestDevelopmentYear { get; }
        int LatestDevelopmentYear { get; }

        double? GetIncrementalValue(int originYear, int developmentYear);
        double? GetCumulativeValue(int originYear, int developmentYear);
    }
}
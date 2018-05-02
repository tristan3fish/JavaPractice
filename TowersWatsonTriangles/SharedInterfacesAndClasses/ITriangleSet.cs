using System.Collections.Generic;

namespace SharedInterfacesAndClasses
{
    public interface ITriangleSet
    {
        int EarlyestOriginYearForAllTriangles { get; }
        int LatestOriginYearForAllTriangles { get; }
        int EarlyestDevelopmentYearForAllTriangles { get; }
        int LatestDevelopmentYearForAllTriangles { get; }
        int DevelopmentYearRange { get; }
        IDictionary<string, ITriangle> TriangleDictionary { get; }
    }
}
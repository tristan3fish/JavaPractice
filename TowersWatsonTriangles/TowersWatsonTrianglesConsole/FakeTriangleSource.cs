using System.Collections.Generic;
using SharedInterfacesAndClasses;

namespace TowersWatsonTriangles
{
    class FakeTriangleSource : ITriangleSource
    {
        public ITriangleSet TriangleSet
        {
            get
            {
                return new TriangleSet(
                    new Dictionary<string, ITriangle>
                    {
                        {"myTriangle", GetTriangle("myTriangle")}
                    }
                );
            }
        }

        private ITriangle GetTriangle(string triangleName)
        {
            var triangleDatapoints = new List<TriangleDataPoint>
            {
                new TriangleDataPoint(1995,1995,100),
                new TriangleDataPoint(1995,1996,50),
                new TriangleDataPoint(1995,1997,200),

                new TriangleDataPoint(1996,1996,80),
                new TriangleDataPoint(1996,1997,40),

                new TriangleDataPoint(1997,1997,120)
            };

            return new Triangle(triangleName, triangleDatapoints);
        }

    }
}
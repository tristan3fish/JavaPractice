using System.Collections.Generic;

namespace SharedInterfacesAndClasses
{
    public interface ITriangleDestination
    {
        void PutTriangles(ITriangleSet triangleSet);
    }
}
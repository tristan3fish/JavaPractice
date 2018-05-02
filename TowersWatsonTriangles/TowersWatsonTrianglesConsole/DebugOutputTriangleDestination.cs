using SharedInterfacesAndClasses;
using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Text;

namespace TowersWatsonTriangles
{
    class DebugOutputTriangleDestination : ITriangleDestination
    {
        private readonly ITriangleSetSummarisationStrategy _summarisationStrategy;

        public DebugOutputTriangleDestination(ITriangleSetSummarisationStrategy summarisationStrategy)
        {
            _summarisationStrategy = summarisationStrategy;
        }

        public void PutTriangles(ITriangleSet triangleSet)
        {
            var result = _summarisationStrategy.GetTriangleSetSummary(triangleSet);
            
            Debug.WriteLine(result);
        }
    }
}
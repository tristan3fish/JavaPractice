using System.Diagnostics;
using System.IO;
using SharedInterfacesAndClasses;

namespace CsvSourceAndDestination
{
    public class CsvTriangleDestination : ITriangleDestination
    {
        private readonly ITriangleSetSummarisationStrategy _summarisationStrategy;
        private readonly string _fileLocation;

        public CsvTriangleDestination(string fileLocation, ITriangleSetSummarisationStrategy summarisationStrategy)
        {
            _summarisationStrategy = summarisationStrategy;
            _fileLocation = fileLocation;
        }

        public void PutTriangles(ITriangleSet triangleSet)
        {
            var result = _summarisationStrategy.GetTriangleSetSummary(triangleSet);

            File.AppendAllText(_fileLocation, result);
        }
    }
}
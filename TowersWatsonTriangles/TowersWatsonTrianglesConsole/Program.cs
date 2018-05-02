using System;
using System.Configuration;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using CsvSourceAndDestination;
using SharedInterfacesAndClasses;

namespace TowersWatsonTriangles
{
    class Program
    {
        private readonly ITriangleSource _triangleSource;
        private readonly ITriangleDestination _triangleDestination ;
        private readonly ITriangleSetSummarisationStrategy _summarisationStrategy;

        static void Main(string[] args)
        {
            try
            {
                new Program().Execute();
            }
            catch (FileNotFoundException e)
            {
                Console.WriteLine(e.Message);
                Console.ReadKey();
            }
            catch (FormatException e)
            {
                Console.WriteLine(e.Message);
                Console.ReadKey();
            }
        }

        public Program()
        {
            //_triangleSource = new FakeTriangleSource();
            _triangleSource = new CsvTriangleSource(ConfigurationManager.AppSettings["InputFileLocation"]);
            
            _summarisationStrategy = new TriangleSetSummarisationStrategy();
            //_triangleDestination = new DebugOutputTriangleDestination(_summarisationStrategy);
            _triangleDestination = new CsvTriangleDestination(ConfigurationManager.AppSettings["OutputFileLocation"], _summarisationStrategy);
        }

        void Execute()
        {
            var triangleSet = _triangleSource.TriangleSet;

            _triangleDestination.PutTriangles(triangleSet);
        }
    }
}
using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using SharedInterfacesAndClasses;

namespace CsvSourceAndDestination
{
    public class CsvTriangleSource : ITriangleSource
    {
        private ITriangleSet _triangleSet;
        public ITriangleSet TriangleSet
        {
            get { return _triangleSet; }
        }

        public CsvTriangleSource(string fileLocation)
        {

            if (!File.Exists(fileLocation))
            {
                throw new FileNotFoundException("Input file not found: " + fileLocation + " Please edit TowersWatsonTriangles.exe.config");
            }

            var csvRows = ParseCsv(fileLocation);

            _triangleSet = new TriangleSet(BuildTriangles(csvRows));

        }

        private IDictionary<string, ITriangle> BuildTriangles(List<string[]> csvRows)
        {
            //could potentially read header row to cope with columns changing order. will keep it simple for now
            var dataRows = csvRows.Skip(1);

            var triangleDictionary = new Dictionary<string, ITriangle>();

            var dataGroups = dataRows.GroupBy(row => row[0]).ToArray();
            foreach (var dataGroup in dataGroups)
            {
                
                var triangleDatapoints = new List<TriangleDataPoint>();
                foreach (var row in dataGroup)
                {
                    try
                    {
                        int originYear = int.Parse(row[1]);
                        int developmentYear = int.Parse(row[2]);
                        double value = double.Parse(row[3]);
                        triangleDatapoints.Add(new TriangleDataPoint(originYear, developmentYear, value));
                    }
                    catch (FormatException e)
                    {
                        throw new FormatException("Row bad format: " + row[0] + ", " + row[1] + ", " + row[2] + ", " + row[3], e);
                    }

                }

                var triangleName = dataGroup.Key;
                triangleDictionary.Add(triangleName, new Triangle(triangleName, triangleDatapoints));

            }

            return triangleDictionary;
        }

        //http://danashurst.com/parsing-a-csv-file/
        private List<string[]> ParseCsv(string path)
        {   
            List<string[]> parsedData = new List<string[]>();

            using (StreamReader readFile = new StreamReader(path))
            {
                string line;
                string[] row;

                while ((line = readFile.ReadLine()) != null)
                {
                    row = line.Split(',').Select(s => s.Trim()).ToArray();
                    parsedData.Add(row);
                }
            }

            return parsedData.Where(RowFilterPredicate()).ToList();
        }

        private Func<string[], bool> RowFilterPredicate()
        {
            return row => row!=null && row.Length > 0 && IsNotEmptyRow(row);
        }

        private bool IsNotEmptyRow(string[] row)
        {
            return !(row.Length == 1 && row.First() == "");
        }



    }
}

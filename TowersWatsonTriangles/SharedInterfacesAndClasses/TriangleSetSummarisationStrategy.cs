using System.Text;

namespace SharedInterfacesAndClasses
{
    public class TriangleSetSummarisationStrategy : ITriangleSetSummarisationStrategy
    {
        public string GetTriangleSetSummary(ITriangleSet triangleSet)
        {
            StringBuilder sb = new StringBuilder();

            sb.Append(triangleSet.EarlyestOriginYearForAllTriangles + ", ");
            sb.Append(triangleSet.DevelopmentYearRange + "\n");

            foreach (var triangle in triangleSet.TriangleDictionary.Values)
            {
                sb.Append(triangle.ProductName + ", ");

                for (int i = triangleSet.EarlyestOriginYearForAllTriangles;
                    i <= triangleSet.LatestOriginYearForAllTriangles;
                    i++)
                {
                    for (int j = 0; j < triangleSet.DevelopmentYearRange; j++)
                    {
                        var oYear = i;
                        var dYear = j + triangleSet.EarlyestDevelopmentYearForAllTriangles;
                        if (oYear <= dYear)
                        {
                            sb.Append(triangle.GetCumulativeValue(oYear, dYear) + ", ");
                        }
                    }
                }
                sb.Remove(sb.Length-2, 1);

                sb.AppendLine();
            }
            sb.Append("\n\n");
            return sb.ToString();
        }
    }
}
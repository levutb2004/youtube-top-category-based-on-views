import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class PopularBasedOnViewsPartitioner extends Partitioner<Text, Text> {
    @Override
    public int getPartition(Text key, Text value, int numReduceTasks) {
        try {
            // Extract comment_count from the value
            String[] fields = value.toString().split(",");
            int commentCount = Integer.parseInt(fields[1].trim()); // comment_count is the second field in value

            // Partition based on comment_count ranges
            if (commentCount < 100) {
                return 0;
            } else if (commentCount < 500) {
                return 1;
            } else if (commentCount < 1000) {
                return 2;
            } else if (commentCount < 5000) {
                return 3;
            } else if (commentCount < 10000) {
                return 4;
            } else {
                return 5;
            }
        } catch (NumberFormatException e) {
            // Default to partition 0 for invalid data
            return 0;
        }
    }
}

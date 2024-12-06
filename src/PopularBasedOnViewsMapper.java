import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class PopularBasedOnViewsMapper extends Mapper<Object, Text, Text, Text> {
    @Override
    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String[] fields = line.split(",");

        try {
            // Extract fields (adjust indexes based on dataset structure)
            String categoryId = fields[4].trim();        // category_id
            String views = fields[7].trim();            // views
            String commentCount = fields[10].trim();    // comment_count

            // Emit category_id as key and "views,comment_count" as value
            context.write(new Text(categoryId), new Text(views + "," + commentCount));
        } catch (Exception e) {
            // Skip invalid rows
            System.err.println("Invalid input: " + line);
        }
    }
}

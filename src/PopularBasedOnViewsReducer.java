import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class PopularBasedOnViewsReducer extends Reducer<Text, Text, Text, Text> {
	@Override
	public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
	    long totalViews = 0;

	    for (Text value : values) {
	        String[] fields = value.toString().split(",");
	        try {
	            // Accumulate views
	            totalViews += Long.parseLong(fields[0].trim()); // views is the first field in value
	        } catch (NumberFormatException e) {
	            System.err.println("Invalid views: " + value.toString());
	        }
	    }

	    // Skip categories with 0 views
	    if (totalViews > 0) {
	        context.write(key, new Text(String.valueOf(totalViews)));
	    }
	}
}

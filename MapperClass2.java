import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

/**
 *
 * @author hduser
 */
public class MapperClass2 extends MapReduceBase implements Mapper<LongWritable,Text,Text,IntWritable>
{
    static int i=1;
    @Override
    public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException 
    {
        String line=value.toString();
        //i++;
        output.collect(new Text(line), new IntWritable(i));
    }
    
}

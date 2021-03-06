import java.io.IOException;
import java.util.Iterator;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;
import static java.lang.System.exit;

/**
 *
 * @author hduser
 */
public class ReduceClass extends MapReduceBase implements Reducer<Text,IntWritable,Text,IntWritable>
{

    @Override
    public void reduce(Text key, Iterator<IntWritable> values, OutputCollector<Text,IntWritable> output, Reporter reporter) throws IOException 
    {
           int sum=0;
        while(values.hasNext())
        {
            sum=sum+values.next().get();
        }
	 if(sum==1)
	{
		System.out.println("Files are not equal");
           	 exit(1);
	}
            
        if(sum==2)
        	output.collect(key, new IntWritable(sum));
	System.out.println("Files are equal");
            
        
    }
        
    
}

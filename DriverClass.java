import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.lib.MultipleInputs;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

/**
 *
 * @author hduser
 */
public class DriverClass extends Configured implements Tool
{

    @Override
    public int run(String[] args) throws Exception 
    {
        JobConf conf= new JobConf(getConf(),DriverClass.class);
        conf.setJobName("File Comparison");
        conf.setOutputKeyClass(Text.class);
        conf.setOutputValueClass(IntWritable.class);
        conf.setReducerClass(ReduceClass.class);
        MultipleInputs.addInputPath(conf, new Path(args[0]),TextInputFormat.class,MapperClass1.class);
        MultipleInputs.addInputPath(conf, new Path(args[1]),TextInputFormat.class,MapperClass2.class);
        FileOutputFormat.setOutputPath(conf, new Path(args[2]));
        JobClient.runJob(conf);
        return 0;
        
    }
    public static void main(String[] args) throws Exception
    {
        int res=ToolRunner.run(new Configuration(),new DriverClass(),args);
        System.exit(res);
    }
    
}

package cn.happy;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

import java.io.IOException;
import java.util.StringTokenizer;

/**
 * @Auther: Xiao Yu
 * @Date: Created in 14:59 2018/3/26
 */
public class MyMapReduce {


    public  static  class MyMap extends Mapper<Object,Text,Text,IntWritable>{
        private  Text keyText=new Text();
        private  IntWritable one=new IntWritable(1);
        public void map(Object key,Text value,Context context) throws IOException,InterruptedException{
            StringTokenizer tokenizer=new StringTokenizer(value.toString());
            while (tokenizer.hasMoreTokens()){
                String s = tokenizer.nextToken();
                keyText.set(s);
                context.write(keyText,one);
            }
        }
    }

    public  static  class  MyReduce extends Reducer<Text,IntWritable,Text,IntWritable>{
        private  IntWritable result=new IntWritable(1);
         int i=0;
        public  void reduce(Text key,Iterable<IntWritable> values,Context context) throws  IOException,InterruptedException{
            context.write(new Text("第"+(++i)+"次"),new IntWritable(0));
            int sum=0;
            for (IntWritable value:values) {
                sum+=value.get();
            }
            result.set(sum);
            context.write(key,result);
        }

    }


    public static void main(String[] args) throws Exception{
        Configuration conf=new Configuration();
        String[] others=new GenericOptionsParser(conf,args).getRemainingArgs();
        if(others.length!=2){
            System.err.print("Usage:MinMaxCountDirive<int><out>");
            System.exit(2);
        }
        Job job=new Job(conf,"haha");
        job.setJarByClass(MyMapReduce.class);
        job.setMapperClass(MyMap.class);
        job.setReducerClass(MyReduce.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        FileInputFormat.addInputPath(job,new Path(others[0]));
        FileOutputFormat.setOutputPath(job,new Path(others[1]));
        System.exit(job.waitForCompletion(true)?0:1);
    }


}





















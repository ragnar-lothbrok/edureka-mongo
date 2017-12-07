package com.edureka.mongo.brandbson;

import java.io.IOException;

import org.apache.hadoop.conf.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;

import com.mongodb.hadoop.*;
import com.mongodb.hadoop.splitter.SplitFailedException;
import com.mongodb.hadoop.util.*;

public class BrandProductCountJob {

	public static void main(String[] args)
			throws IOException, ClassNotFoundException, InterruptedException, SplitFailedException {
		final Configuration conf = new Configuration();
		conf.set("mapred.input.dir", "file:///Users/raghugupta/Documents/Mongo/grocery_db_index/product.bson");
		// conf.setBoolean("mongo.input.split.create_input_splits", false);
		MongoConfigUtil.setInputFormat(conf, BSONFileInputFormat.class);
		MongoConfigUtil.setCreateInputSplits(conf, false);
		MongoConfigUtil.setBSONReadSplits(conf, false);
		MongoConfigUtil.setBSONPathFilter(conf, BSONPathFilter.class);
		MongoConfigUtil.setOutputURI(conf, "mongodb://localhost/grocery_db_index.test");

		MongoConfigUtil.setOutputKey(conf, Text.class);
		MongoConfigUtil.setOutputValue(conf, IntWritable.class);

		@SuppressWarnings("deprecation")
		final Job job = new Job(conf, "submit counter");
		job.setJarByClass(BrandProductCountJob.class);
		job.setMapperClass(BrandMapper.class);
		job.setReducerClass(BrandProductReducer.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);
		job.setOutputFormatClass(MongoOutputFormat.class);
		job.setInputFormatClass(MongoConfigUtil.getInputFormat(conf));
		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}
}

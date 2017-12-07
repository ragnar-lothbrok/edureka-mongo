package com.edureka.mongo.brands;

import org.apache.hadoop.conf.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;

import com.mongodb.hadoop.*;
import com.mongodb.hadoop.util.*;

public class BrandProductCount {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {

		final Configuration conf = new Configuration();
		MongoConfigUtil.setInputURI(conf, "mongodb://localhost/grocery_db_index.product");
		MongoConfigUtil.setOutputURI(conf, "mongodb://localhost/grocery_db_index.brand_product_count");
		System.out.println("Conf: " + conf);

		final Job job = new Job(conf, "Brand wise product count");

		job.setJarByClass(BrandProductCount.class);

		job.setMapperClass(BrandMapper.class);

		job.setCombinerClass(BrandProductReducer.class);
		job.setReducerClass(BrandProductReducer.class);

		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);

		job.setInputFormatClass(MongoInputFormat.class);
		job.setOutputFormatClass(MongoOutputFormat.class);

		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}
}

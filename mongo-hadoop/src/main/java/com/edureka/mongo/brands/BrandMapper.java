package com.edureka.mongo.brands;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.bson.BSONObject;

public class BrandMapper extends Mapper<Object, BSONObject, Text, IntWritable> {

	private static final Log log = LogFactory.getLog(BrandMapper.class);

	private final static IntWritable one = new IntWritable(1);
	private final Text word = new Text();

	public void map(Object key, BSONObject value, Context context) throws IOException, InterruptedException {

		log.info("key: " + key);
		log.info("value: " + value);

		word.set(value.get("brand").toString());
		context.write(word, one);
	}
}
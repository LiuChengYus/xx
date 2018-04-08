package com.accp.v.test;

import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;

public class KafkaConsumerMsgTask implements Runnable {
	private KafkaStream m_stream;
	private int m_threadNumber;

	public KafkaConsumerMsgTask(KafkaStream stream, int threadNumber) {
		m_threadNumber = threadNumber;
		m_stream = stream;
	}

	public void run() {
		ConsumerIterator<byte[], byte[]> it = m_stream.iterator();
		while (it.hasNext()){
			System.out.println("获取数据:" + m_threadNumber + ": "
					+ new String(it.next().message()));
		}
	}
}

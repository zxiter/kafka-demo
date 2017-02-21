package kafka.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;

public class ConsumerMsgTask extends Thread
{
	final Logger logger = LoggerFactory.getLogger(ConsumerMsgTask.class);

	private KafkaStream<byte[], byte[]> m_stream;
	private int m_threadNumber;

	public ConsumerMsgTask(KafkaStream<byte[], byte[]> stream, int threadNumber)
	{
		m_threadNumber = threadNumber;
		m_stream = stream;
	}

	public void run()
	{
		ConsumerIterator<byte[], byte[]> it = m_stream.iterator();
		while (it.hasNext())
			logger.info("Thread " + m_threadNumber + ": " + new String(it.next().message()));
		logger.info("Shutting down Thread: " + m_threadNumber);
	}
}

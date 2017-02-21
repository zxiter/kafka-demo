package demo.kafka;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App
{
	final Logger logger = LoggerFactory.getLogger(App.class);

	@Test
	public void testLog4j()
	{
		for (int i = 0; i < 20; i++)
		{
			logger.info("send the message to kafka [" + i + "]");
			try
			{
				Thread.sleep(1000);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

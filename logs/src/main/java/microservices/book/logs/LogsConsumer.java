package microservices.book.logs;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LogsConsumer {

	@RabbitListener(queues = "logs.queue")
	public void log(final String msg, @Header("level") String level, @Header("amqp_appId") String appId) {
		Marker marker = MarkerFactory.getMarker(appId);
		if (level.equalsIgnoreCase("INFO")) {
			log.info(marker, msg);
		} else if (level.equalsIgnoreCase("ERROR")) {
			log.error(marker, msg);
		} else if (level.equalsIgnoreCase("WARN")) {
			log.warn(marker, msg);
		}
	}
}

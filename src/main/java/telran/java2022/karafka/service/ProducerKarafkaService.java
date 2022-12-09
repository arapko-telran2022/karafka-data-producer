package telran.java2022.karafka.service;

import java.util.Random;
import java.util.function.Supplier;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import telran.java2022.karafka.dto.PulseDto;

@Service
public class ProducerKarafkaService {
	Random random = new Random();
	int minId = 1;
	int maxId = 10;
	int minData = 1;
	int maxData = 200;


    @Bean
    Supplier<PulseDto> produceData() {
        return () -> {
            int id = minId + random.nextInt(maxId - minId + 1);
            long timestamp = System.currentTimeMillis();
            int data = minData + random.nextInt(maxData - minData + 1);
            PulseDto pulseDto = new PulseDto(id, timestamp, data);
            System.out.println("Produce: " + pulseDto);
            return pulseDto;
        };
    }
	
}

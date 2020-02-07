package tatsumibruno.samples.websocketprocessor.process.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Service
public class ProcessorService {

    private SimpMessagingTemplate template;

    @Autowired
    public ProcessorService(SimpMessagingTemplate template) {
        this.template = template;
    }

    @Async
    public void execute() {
        try {
            Thread.sleep(2000L);
            template.convertAndSend("/statusProcessor", gerarMensagem(1));
            Thread.sleep(2000L);
            template.convertAndSend("/statusProcessor", gerarMensagem(2));
            Thread.sleep(2000L);
            template.convertAndSend("/statusProcessor", gerarMensagem(3));
        } catch (InterruptedException e) {
            log.error("Erro durante o procesamento.", e);
        }
    }

    private String gerarMensagem(int etapa) {
        return String.format("Executada a etapa %s às %s", etapa,
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
    }
}

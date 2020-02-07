package tatsumibruno.samples.websocketprocessor.process.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tatsumibruno.samples.websocketprocessor.process.CreatedProcess;
import tatsumibruno.samples.websocketprocessor.process.domain.ProcessorService;

import java.time.LocalDateTime;

@CrossOrigin
@RestController
@RequestMapping(path = "/api")
public class ProcessController {

    private ProcessorService service;

    @Autowired
    public ProcessController(ProcessorService service) {
        this.service = service;
    }

    @PutMapping
    public ResponseEntity<CreatedProcess> execute() {
        service.execute();
        return ResponseEntity.ok().body(new CreatedProcess(LocalDateTime.now()));
    }
}

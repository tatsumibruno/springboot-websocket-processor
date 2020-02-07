package tatsumibruno.samples.websocketprocessor.process;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CreatedProcess {
    private LocalDateTime startAt;
}

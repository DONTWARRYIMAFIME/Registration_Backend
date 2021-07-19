package by.spring.registration.Registration_Backend.registration.token;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {

    private final ConfirmationTokenRepository repositoryToken;

    public void saveConfirmationToken(ConfirmationToken token) {
        repositoryToken.save(token);
    }

    public Optional<ConfirmationToken> getToken(String token) {
        return repositoryToken.findByToken(token);
    }

    public int setConfirmedAt(String token) {
        return repositoryToken.updateConfirmedAt(
                token, LocalDateTime.now());
    }

}

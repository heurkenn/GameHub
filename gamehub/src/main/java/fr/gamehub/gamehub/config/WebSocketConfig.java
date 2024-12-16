package fr.gamehub.gamehub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(@SuppressWarnings("null") MessageBrokerRegistry config) {
        // Active un broker simple pour les topics et configure les préfixes des messages
        config.enableSimpleBroker("/topic", "/queue")
              .setHeartbeatValue(new long[]{10000, 10000}) // Heartbeat chaque 10 secondes
              .setTaskScheduler(heartBeatScheduler()); // Configure le TaskScheduler
        config.setApplicationDestinationPrefixes("/app"); // Préfixe pour les messages clients
    }

    @Override
    public void registerStompEndpoints(@SuppressWarnings("null") StompEndpointRegistry registry) {
        // Déclaration du point d'entrée WebSocket avec SockJS
        registry.addEndpoint("/ws")
                .setAllowedOrigins("http://localhost:8080", "http://gamehub.com") // Remplace "*" par vos domaines
                .withSockJS();
    }

    @Bean
    public ThreadPoolTaskScheduler heartBeatScheduler() {
        // Bean pour gérer les heartbeats
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(1);
        scheduler.setThreadNamePrefix("wss-heartbeat-thread-");
        scheduler.initialize();
        return scheduler;
    }
}

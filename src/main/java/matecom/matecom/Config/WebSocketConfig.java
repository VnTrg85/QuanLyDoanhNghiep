package matecom.matecom.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // Cấu hình message broker
        config.enableSimpleBroker("/topic"); // Tin nhắn từ server sẽ được gửi đến /topic
        config.setApplicationDestinationPrefixes("/app"); // Client gửi đến server qua /app
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws") // Điểm kết nối WebSocket
                .setAllowedOrigins("http://yourfrontend.com") // Chỉ chấp nhận kết nối từ nguồn này
                .withSockJS(); // Hỗ trợ SockJS (nếu không có WebSocket trên browser)
    }
}

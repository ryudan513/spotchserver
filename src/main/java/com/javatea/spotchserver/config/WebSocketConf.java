package com.javatea.spotchserver.config;

import com.javatea.spotchserver.handler.*;
import com.javatea.spotchserver.objects.websocket.FavoriteMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;


/**
 * WebSocket通信のコンフィグクラス
 */
@Configuration
@EnableWebSocket
public class WebSocketConf implements WebSocketConfigurer {
	@Autowired
	private FindHandler findHandler;
	@Autowired
	private CreateHandler createHandler;
	@Autowired
	private SignUpHandler signUpHandler;
	@Autowired
	private SignInHandler signInHandler;
	@Autowired
	private FavoriteHandler favoriteHandler;
	/**
	 * ハンドラの登録を行う
	 * @param registry
	 */
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(findHandler,"/socket/articles/find").setAllowedOrigins("*");
		registry.addHandler(createHandler,"/socket/articles/create").setAllowedOrigins("*");
		registry.addHandler(favoriteHandler,"socket/articles/favorite").setAllowedOrigins("*");
		registry.addHandler(signUpHandler,"/socket/user/signup").setAllowedOrigins("*");
		registry.addHandler(signInHandler,"/socket/user/signin").setAllowedOrigins("*");
	}
}

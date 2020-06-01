package com.fullnesssboot2.text;

import com.fullnesssboot2.text.bean.MorningGreet;
import com.fullnesssboot2.text.interfacedepnd.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class TextApplication {
	public static void main(String[] args) {
		// 1. SpringBoot実行結果をApplicatinContext型の変数に入れる
		ApplicationContext context = SpringApplication.run(TextApplication.class, args);
		// 4. これでSpringBoot起動後の処理を追加できる
		context.getBean(TextApplication.class).run();
	}
	// 3. DI（インジェクション）
	@Autowired // <-自動的にDIコンテナがインスタンス生成してくれる
	Calculator addCalcu; // <-クラス名の先頭単語を小文字にした変数

	@Autowired
	Calculator subCalcu; // <-クラス名の先頭単語を小文字にした変数

	// 演習1のDI部分
	@Autowired
	MorningGreet morningGreet;

	// 2. 追加で動かしたいメソッドを定義
	public void run(){
		// 演習1のDIしたインスタンスを実行
		morningGreet.say("山田");
	}
}

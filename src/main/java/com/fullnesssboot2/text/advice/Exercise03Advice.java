package com.fullnesssboot2.text.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

// 1. ComponentとAspectのアノテーションをクラスの上につける
// （Aspectのアノテーションはaopの依存関係（外部ライブラリ）を入れないといけない）
    // build.gradleにて追加する
@Component
@Aspect
public class Exercise03Advice {

    // 3.ログのフィールドを追加
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // 2. AroundとかBeforeとかの横断的関心事を追加したいタイミングに合わせた
        // アノテーションをメソッドの上につける
        // メソッドのシグニチャ（外枠）は戻り値はObject引数はProceedingJointPoint型の引数を入れる
        // 例外を送出できるようにするためにThrowableをthrows宣言する
    @Around("execution(* com.fullnesssboot2.text.bean.*.*(..))")
    public Object sample(ProceedingJoinPoint joinPoint) throws Throwable{
        // 横断的関心毎を差し込む対象のメソッド名を取得してログに出力（処理前）
        logger.info("開始:"+joinPoint.getSignature().getName());
        // 実際の中心的関心毎の処理
        Object result = joinPoint.proceed(); // 戻り値を取得したい場合はObject型の変数で取得可能
        // 横断的関心毎を差し込む対象のメソッド名を取得してログに出力（処理後）
        // 引数をとる場合
        for (Object o : joinPoint.getArgs()){
            logger.info("引数の値:"+o);
        }
        logger.info("終了:"+joinPoint.getSignature().getName());
        // 戻り値を取得する場合
        logger.info("戻り値:"+result);
        return result;
    }
}

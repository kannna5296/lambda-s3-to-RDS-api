# lambda-s3-to-RDS-api

Kotlinとaws-sdk-for-javaでpresignedUrl取得する処理を書く

## ローカルのminioでのファイルシェア用URL
こういうのをKotlinで取得したい（先に答えを求めておく） <br>
これがpresignedUrl？？ <br>
http://172.28.0.2:9000/localbucket/test?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=M89F8LGVLK401DSJE30M%2F20220609%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20220609T140918Z&X-Amz-Expires=604800&X-Amz-Security-Token=eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJhY2Nlc3NLZXkiOiJNODlGOExHVkxLNDAxRFNKRTMwTSIsImV4cCI6MTY1NDc4Njk2NiwicGFyZW50IjoibWluaW9hZG1pbnVzZXIifQ.lIdWvK3zXj1i1dNUtK-ssvOn7PRoBiLkDA16wqn3JMNJq7_PQSfnYVoAdx4CyXS3nLA8YNmDUBhHHv0uL1Kk_w&X-Amz-SignedHeaders=host&versionId=null&X-Amz-Signature=952f9c26252c177b1c2edf0613cf7fcb76b94b4eb13e63447b4e255d4816918e

取得方法
minioのコンソールでオブジェクトをチェック > Share > 下記画面から確認可能
<img width="786" alt="スクリーンショット 2022-06-09 23 04 07" src="https://user-images.githubusercontent.com/58777139/172866682-98081252-236b-4eed-80cf-0317ce71c47c.png">

# lambda-s3-to-RDS-api

Kotlinとaws-sdk-for-javaでpresignedUrl取得する処理を書く

## ローカルのminioでのファイルシェア用URL
こういうのをKotlinで取得したい（先に答えを求めておく） <br>
これがpresignedUrl？？ <br>
http://172.27.0.2:9999/localbucket/test?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=PUEX42RFJNEKISG7B067%2F20220609%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20220609T140204Z&X-Amz-Expires=604800&X-Amz-Security-Token=eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJhY2Nlc3NLZXkiOiJQVUVYNDJSRkpORUtJU0c3QjA2NyIsImV4cCI6MTY1NDc4Njc2NywicGFyZW50IjoibWluaW9hZG1pbnVzZXIifQ.pL8jDMOgcbIeniiozfsMJCrEfA6_fqB84l6qc2ZA0TqVaudLOUFj5xpsQgjlbpuP8YbDkEnUUJcWbbg0j1fqcQ&X-Amz-SignedHeaders=host&versionId=null&X-Amz-Signature=7500145294dc044021455fd0e2f6a572f42e0f54409130d4c5af5acccc61c2fe

取得方法
minioのコンソールでオブジェクトをチェック > Share > 下記画面から確認可能
<img width="786" alt="スクリーンショット 2022-06-09 23 04 07" src="https://user-images.githubusercontent.com/58777139/172866682-98081252-236b-4eed-80cf-0317ce71c47c.png">

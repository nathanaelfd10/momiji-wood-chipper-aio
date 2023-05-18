start "Product List Worker" mvn spring-boot:run -Dspring-boot.run.profiles=product-list -DprojectId=momiji-381514 -DtopicId=product-stream -DGOOGLE_APPLICATION_CREDENTIALS=D:/Kuliah/software-workspaces/personal-workspace/momiji/momiji-dataflow/credential/gcp_service_account_credential.json
start "Product Worker" mvn spring-boot:run -Dspring-boot.run.profiles=product -Dserver.port=8082 -DprojectId=momiji-381514 -DtopicId=product-stream -DGOOGLE_APPLICATION_CREDENTIALS=D:/Kuliah/software-workspaces/personal-workspace/momiji/momiji-dataflow/credential/gcp_service_account_credential.json
start "Extractor Worker" mvn spring-boot:run -Dspring-boot.run.profiles=extractor -Dserver.port=8083 -DprojectId=momiji-381514 -DtopicId=product-stream -DGOOGLE_APPLICATION_CREDENTIALS=D:/Kuliah/software-workspaces/personal-workspace/momiji/momiji-dataflow/credential/gcp_service_account_credential.json
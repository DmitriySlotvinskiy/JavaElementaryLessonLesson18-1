package slotvinskiy.com;

//1) Программно послать HEAD запрос для файла доступного по прямой ссылке, например:
//https://dl.dropboxusercontent.com/s/vxnydq4xjkmefrp/CLUVAL.java
//Скачать сначала первую половину этого файла, а потом докачать вторую.
//Range:bytes=0-500

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GetRequestToDownloadTxtFile {

    public static final String URL = "https://dl.dropboxusercontent.com/s/vxnydq4xjkmefrp/CLUVAL.java";
    public static final String FILE_NAME = "file.txt";
    public static final String FIRST_PART_RANGE = "bytes=0-500";

    public static void main(String[] args) {

        OkHttpClient client = new OkHttpClient().newBuilder().build();
        int contentLength = headRequest(client);
        getDataAndWrite(client, contentLength);
        client.connectionPool().evictAll();
    }

    private static void getDataAndWrite(OkHttpClient client, int contentLength) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            Request request = new Request.Builder()
                    .url(URL)
                    .get()
                    .addHeader("Range", FIRST_PART_RANGE)
                    .build();
            Response response = client.newCall(request).execute();
            bw.write(response.body().string());

            request = new Request.Builder()
                    .url(URL)
                    .get()
                    .addHeader("Range", "bytes=500-" + contentLength)
                    .build();

            response = client.newCall(request).execute();
            bw.write(response.body().string());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int headRequest(OkHttpClient client) {
        int contentLength = -1;
        Request request = new Request.Builder()
                .url(URL)
                .head()
                .build();
        try {
            Response response = client.newCall(request).execute();
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            String contentLengthStr = response.header("Content-Length");
            contentLength = Integer.parseInt(contentLengthStr);
            response.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentLength;
    }
}

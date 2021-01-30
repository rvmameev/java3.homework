package java3.lesson4.homework;

import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void main(String[] args)
    {
        // 1. Создать три потока, каждый из которых выводит определенную букву (A, B и C) 5 раз (порядок – ABСABСABС).
        // Используйте wait/notify/notifyAll.

        char[] letters = new char[] {'A', 'B', 'C'};
        List<Thread> threads = new ArrayList<>(letters.length);

        RepitPrinter printer = new RepitPrinter(letters, 5);

        new Thread(() -> printer.print(0)).start();
        new Thread(() -> printer.print(1)).start();
        new Thread(() -> printer.print(2)).start();

        // 2. На серверной стороне сетевого чата реализовать управление потоками через ExecutorService.

//        public class ClientHandler {
//
//            ...
//
//            public ClientHandler(Server server, Socket socket) {
//                ...
//
//            ++ старый код
//            new Thread(() ->{
//                try {
//                    autorization();
//                    sendMsg(History.loadHistory());
//                    server.broadcast(this,getNick() + " подключился");
//                    read();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                } finally {
//                    close();
//                }
//            }).start();
//            -- старый код
//
//            ++ новый код
//            ExecutorService service = Executors.newCachedThreadPool();
//            executorService.execute(() ->
//            {
//                try
//                {
//                    autorization();
//                    sendMsg(History.loadHistory());
//                    server.broadcast(this, getNick() + " подключился");
//                    read();
//                } catch (IOException e)
//                {
//                    e.printStackTrace();
//                } finally
//                {
//                    close();
//                }
//            });
//            service.shutdown();
//            -- новый код
//
//                ...
//            }
//
//            ...
//        }
    }
}

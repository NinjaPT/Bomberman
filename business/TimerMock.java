package business;

import presentation.Viewer;
import presentation.swing.GameViewer;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class TimerMock
{
    private Timer timer = new Timer();
    private Viewer viewer = new GameViewer();
    private int position = 1;

    public TimerMock()
    {
        viewer.refreshLayout();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                action();
            }
        }, 0, 1000);
    }

    private void action()
    {
        System.out.println("action: " + position);
        ++position;
        viewer.play();
        viewer.printGame();
        viewer.refreshLayout();

    }

    public static void main(String[] args) throws IOException
    {
        java.net.InetAddress localMachine = java.net.InetAddress.getLocalHost();
        System.out.println("Hostname of local machine: " + localMachine.getHostName());
        new TimerMock();
        //System.in.read();
    }
}

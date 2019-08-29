/*
 * 
 * 
 */
 import java.rmi.server.UnicastRemoteObject;
 import observer.BookingDetailObserver;
 import java.rmi.RemoteException;
 import model.Film;
 import java.util.ArrayList;
 import model.BookingDetail;
 
  /**
  * @author M.R.P.Peiris
  */
  public class BookingDetailObserverImpl extends UnicastRemoteObject implements BookingDetailObserver{
	  private ReserveSeat reserveSeat;
	  
	  public BookingDetailObserverImpl(ReserveSeat reserveSeat)throws RemoteException{
		  this.reserveSeat=reserveSeat;
	  }
	  
	  
	  @Override
	  public void update(ArrayList<String> seatNameList){
		  reserveSeat.newSeatBooked(seatNameList);
		    
	  }
	  
  }

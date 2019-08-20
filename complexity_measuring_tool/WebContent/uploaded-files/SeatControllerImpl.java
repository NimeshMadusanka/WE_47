/*
 * 
 * 
 */
 package controllerimpl;
 
 
 import java.rmi.server.UnicastRemoteObject;
 import java.rmi.RemoteException;
 import java.io.IOException;
 import java.util.List;
 import controller.SeatController;
 import model.Seat;
 import observer.SeatObserver;
 import fileaccess.SeatFileAccess;
 import reservation.SeatReservation;
 import observerble.SeatObserverble;
 
 /**
  * @author M.R.P.Peiris
  */
  public class SeatControllerImpl extends UnicastRemoteObject implements SeatController, A,B,C{
	  
	  private final SeatFileAccess seatFileAccess=new SeatFileAccess();
	  private static final SeatReservation seatReservation=new SeatReservation();
	  private final SeatObserverble seatObserverble=new SeatObserverble();
	  
	  public SeatControllerImpl()throws RemoteException{
	  }
	  
	  @Override
	  public boolean addSeat(Seat seat)throws RemoteException,IOException,ClassNotFoundException{
		  if(seatFileAccess.addSeat(seat)){
			  seatObserverble.notifySeatObservers(seat);
			  return true;
		  }
		  return false;
	  }
	  
	  @Override
	  public Seat searchSeatBySeatId(String seatId)throws RemoteException,IOException,ClassNotFoundException{
		  return seatFileAccess.searchSeatBySeatId(seatId);
	  }
	  
	  @Override
	  public List<Seat> getAllSeats()throws RemoteException,IOException,ClassNotFoundException{
		  return seatFileAccess.getAllSeats();
	  }
	  
	  @Override
	  public Seat searchSeatBySeatName(String seatName)throws RemoteException,IOException,ClassNotFoundException{
		  return seatFileAccess.searchSeatBySeatName(seatName);
	  }
	  
	  @Override
	  public boolean reserveSeat(String seatId)throws RemoteException{
		  return seatReservation.reserveSeat(seatId,this);
	  }
	  
	  @Override
	  public boolean releseSeat(String seatId)throws RemoteException{
		  return seatReservation.releseSeat(seatId,this);
	  }
	  
	  @Override
	  public void addSeatObserver(SeatObserver seatObserver)throws RemoteException{
		  seatObserverble.addSeatObserver(seatObserver);
	  }
	  
	  @Override
	  public void removeSeatObserver(SeatObserver seatObserver)throws RemoteException{
		  seatObserverble.removeSeatObserver(seatObserver);
	  }
	  
  }

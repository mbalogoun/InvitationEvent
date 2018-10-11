package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Guest {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	
	@ManyToMany(mappedBy = "guests", cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	Set<Event> events = new HashSet<>();

	
	
	public Guest(String name) {
		super();
		this.name = name;
	}

	public Guest() {
		super();
	}
	
	public void addEvent(Event e) {
		events.add(e);
		e.getGuests().add(this);
	}

	@Override
	public String toString() {
		return "Invite [id=" + id + ", name=" + name + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Event> getEvents() {
		return events;
	}

	public void setEvents(Set<Event> events) {
		this.events = events;
	}
	
	
	
}

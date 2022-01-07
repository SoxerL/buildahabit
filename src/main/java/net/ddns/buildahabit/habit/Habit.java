package net.ddns.buildahabit.habit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.GenerationType;

@Entity
@Table(uniqueConstraints = {
		@UniqueConstraint(name = "UniqueNameAndRecurrence", columnNames = { "name", "recurrence" }) })
public class Habit {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable = false, unique = false)
	private String name;

	@Column(nullable = false, unique = false)
	private HabitRecurrence recurrence;

	@Column(nullable = false, unique = false)
	private String description;

	public Habit() {
		super();
	}

	public Habit(String name, HabitRecurrence recurrence, String description) {
		super();
		this.name = name;
		this.recurrence = recurrence;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		this.name = newName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String newDescription) {
		this.description = newDescription;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((recurrence == null) ? 0 : recurrence.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Habit other = (Habit) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (recurrence != other.recurrence)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Habit [id=" + id + ", name=" + name + ", recurrence=" + recurrence.name() + ", description="
				+ description +"]";
	}

}
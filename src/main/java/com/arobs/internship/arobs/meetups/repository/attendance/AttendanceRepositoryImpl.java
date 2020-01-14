package com.arobs.internship.arobs.meetups.repository.attendance;

import com.arobs.internship.arobs.meetups.entity.Attendance;
import com.arobs.internship.arobs.meetups.entity.Proposal;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class AttendanceRepositoryImpl implements AttendanceRepository {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addAttendance(Attendance attendance) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(attendance);
    }

    @Override
    public Attendance getAttendanceById(int attendanceId) {
        Session currentSession = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = currentSession.getCriteriaBuilder();
        CriteriaQuery<Attendance> criteriaQuery = criteriaBuilder.createQuery(Attendance.class);
        Root<Attendance> root = criteriaQuery.from(Attendance.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("attendanceId"), attendanceId));
        Query query = currentSession.createQuery(criteriaQuery);
        return (Attendance) query.getSingleResult();
    }
}

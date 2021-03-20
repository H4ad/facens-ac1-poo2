package com.h4ad.ac1.specifications;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.h4ad.ac1.entities.Event;

import org.springframework.data.jpa.domain.Specification;

public class EventSpecification implements Specification<Event> {

  private static final long serialVersionUID = 1L;

  private EventSearchCriteria criteria;

  public EventSpecification(EventSearchCriteria criteria) {
    this.criteria = criteria;
  }

  public static Specification<Event> add(Specification<Event> spec, EventSearchCriteria criteria) {
    if (spec == null)
      return Specification.where(new EventSpecification(criteria));

    return spec.and(new EventSpecification(criteria));
  }

  @Override
  public Predicate toPredicate(Root<Event> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
    if (criteria.getOperation().equalsIgnoreCase(">")) {
      return builder.greaterThanOrEqualTo(root.<String>get(criteria.getKey()), criteria.getValue().toString());
    } else if (criteria.getOperation().equalsIgnoreCase("<")) {
      return builder.lessThanOrEqualTo(root.<String>get(criteria.getKey()), criteria.getValue().toString());
    } else if (criteria.getOperation().equalsIgnoreCase(":")) {
      if (root.get(criteria.getKey()).getJavaType() == String.class) {
        return builder.like(root.<String>get(criteria.getKey()), "%" + criteria.getValue() + "%");
      } else {
        return builder.equal(root.get(criteria.getKey()), criteria.getValue());
      }
    }

    return null;
  }
}

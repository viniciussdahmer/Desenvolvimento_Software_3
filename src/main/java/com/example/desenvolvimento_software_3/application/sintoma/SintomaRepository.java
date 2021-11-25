package com.example.desenvolvimento_software_3.application.sintoma;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SintomaRepository extends JpaRepository<Sintoma, Long> {
}

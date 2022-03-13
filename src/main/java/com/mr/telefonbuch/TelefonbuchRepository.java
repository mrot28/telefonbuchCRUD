package com.mr.telefonbuch;

import org.springframework.data.jpa.repository.JpaRepository;

interface TelefonbuchRepository extends JpaRepository<Telefonbucheintrag, Long> {

}

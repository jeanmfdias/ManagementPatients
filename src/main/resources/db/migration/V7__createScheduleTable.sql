CREATE TABLE schedules (
    id BIGSERIAL PRIMARY KEY,
    doctor_id BIGSERIAL NOT NULL,
    patient_id BIGSERIAL NOT NULL,
    date TIMESTAMP NOT NULL,

    CONSTRAINT fk_schedules_doctor FOREIGN KEY (doctor_id) REFERENCES doctors(id) ON DELETE CASCADE,
    CONSTRAINT fk_schedules_patient FOREIGN KEY (patient_id) REFERENCES patients(id) ON DELETE CASCADE
);
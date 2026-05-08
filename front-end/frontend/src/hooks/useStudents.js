import { useEffect, useState } from "react";
import {
  getStudents,
  createStudent,
  updateStudent,
  deleteStudent
} from "../services/StudentServices";

export const useStudents = () => {
  const [students, setStudents] = useState([]);
  const [loading, setLoading] = useState(false);

  // LOAD
  const fetchStudents = async () => {
    setLoading(true);
    const data = await getStudents();
    setStudents(data);
    setLoading(false);
  };

  useEffect(() => {
    fetchStudents();
  }, []);

  // CREATE
  const addStudent = async (student) => {
    const newStudent = await createStudent(student);
    setStudents((prev) => [...prev, newStudent]);
  };

  // UPDATE
  const editStudent = async (msv, student) => {
    const updated = await updateStudent(msv, student);

    setStudents((prev) =>
      prev.map((s) => (s.msv === msv ? updated : s))
    );
  };

  // DELETE
  const removeStudent = async (msv) => {
    await deleteStudent(msv);
    setStudents((prev) => prev.filter((s) => s.msv !== msv));
  };

  return {
    students,
    loading,
    addStudent,
    editStudent,
    removeStudent,
    refetch: fetchStudents
  };
};
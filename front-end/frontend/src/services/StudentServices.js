import BASE_URL from "../api/StudentApi";

// GET ALL
export const getStudents = async () => {
  const res = await fetch(BASE_URL);
  return res.json();
};

// CREATE
export const createStudent = async (student) => {
  const res = await fetch(BASE_URL, {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(student)
  });

  return res.json();
};

// UPDATE
export const updateStudent = async (msv, student) => {
  const res = await fetch(`${BASE_URL}/${msv}`, {
    method: "PUT",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(student)
  });

  return res.json();
};

// DELETE
export const deleteStudent = async (msv) => {
  await fetch(`${BASE_URL}/${msv}`, {
    method: "DELETE"
  });
};
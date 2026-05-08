import React from "react";

const StudentTable = ({ students, onEdit, onDelete }) => {
  return (
    <table border={1} width="100%">
      <thead>
        <tr>
          <th>MSV</th>
          <th>Name</th>
          <th>Email</th>
          <th>Class</th>
          <th>Credit</th>
          <th>Status</th>
          <th>BirthDate</th>
          <th>Action</th>
        </tr>
      </thead>

      <tbody>
        {students.map((s) => (
          <tr key={s.msv}>
            <td>{s.msv}</td>
            <td>{s.name}</td>
            <td>{s.email}</td>
            <td>{s.className}</td>
            <td>{s.credit}</td>
            <td>{s.is_active ? "Active" : "Inactive"}</td>
            <td>{s.birthDate}</td>

            <td>
              <button onClick={() => onEdit(s)}>Edit</button>
              <button onClick={() => onDelete(s.msv)}>Delete</button>
            </td>
          </tr>
        ))}
      </tbody>
    </table>
  );
};

export default StudentTable;